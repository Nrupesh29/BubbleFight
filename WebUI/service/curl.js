var URL = "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/";
var MofT = [];
function curlCreateTournament(name, players) {
    return findT(name).then(function (rs) {
        if (rs.length > 0) {
            for (var i = 0; i < rs.length; i++) {
                // console.log(rs[i]);
                if (rs[i].name == name) {
                    alert("tournament's name is existed");
                    return false;
                }
            }
        }

        var getArray = [];

        // players = ["a1", "a2", "a3", "a5"];
        for (var i = 0; i < 4; i++) {
            getArray.push(createP(players[i]));
        }

        return $.when.apply($, getArray).then(function (rs1, rs2, rs3, rs4) {

            return createT({name: name}).then(function (tournament) {
                createM({
                    p1: rs1.id,
                    p2: rs2.id,
                    t: tournament.id,
                    l: 2,
                    d: moment().format('YYYY-DD-MM h:mm:ss')
                });
                return createM({
                    p1: rs3.id,
                    p2: rs4.id,
                    t: tournament.id,
                    l: 2,
                    d: moment().format('YYYY-DD-MM h:mm:ss')
                });
            });
        });
    });


};
function curlLoadTournament(callback) {
    return loadT().then(function (rs) {
        var matches = [];
        console.log(rs);
        rs = _.orderBy(rs, function (e) {
            return parseInt(e.id);
        }, ['desc']);
        console.log(rs);
        rs = rs.slice(0, 5);
        var getArray = [];

        // players = ["a1", "a2", "a3", "a5"];
        for (var i = 0; i < rs.length; i++) {
            getArray.push(findMbyT(rs[i].id).then(function (rs1) {
                MofT = rs1;
                var pArray = [];
                for (var z = 0; z < MofT.length; z++) {
                    pArray.push(findPid(MofT[z].player_one_id, MofT[z], "player1").then(function (p) {
                        // console.log(p);
                    }));
                    pArray.push(findPid(MofT[z].player_two_id, MofT[z], "player2").then(function (p) {
                        // console.log(p);
                    }));
                }

                $.when.apply($, pArray).then(function () {
                    return MofT;
                });
                return MofT;
            }).then(function (rs2) {
                var data = {
                    final: {},
                    semi: []
                };
                for (var j = 0; j < rs2.length; j++) {
                    data.tournament_id = rs2[j].tournament_id;
                    if (rs2[j].level_id == "2") {
                        data.semi.push(rs2[j]);
                    }
                    if (rs2[j].level_id == "1") {
                        data.final = rs2[j];
                        if (data.final && data.final.winner_id != null) {
                            if (data.final.winner_id == data.final.player_one_id) {
                                data.final.winner = data.final.player1;
                            }
                            if (data.final.winner_id == data.final.player_two_id) {
                                data.final.winner = data.final.player2;
                            }
                        }
                    }
                }
                console.log(data);
                matches.push(data);
            }));
        }

        return $.when.apply($, getArray).then(function () {
            console.log(matches);
            for (var i = 0; i < rs.length; i++) {
                rs[i].matches = _.find(matches, function (e) {
                    return e.tournament_id == rs[i].id;
                });
            }
            if (callback)
                callback(rs);
            return rs;
        });

    });
};
function createT(data) {
    return $.post("service/createT.php", data).then(function (rs1) {
        return JSON.parse(rs1);
    });
}

function createM(data) {
    return $.post("service/createM.php", data).then(function (rs1) {
        return JSON.parse(rs1);
    });
}

function createP(name) {
    return findP(name).then(function (rs) {

        if (rs.length > 0) {
            for (var i = 0; i < rs.length; i++) {
                // console.log(rs[i]);
                if (rs[i].name == name) {
                    return rs[i];
                }
            }
        }

        return $.post("service/createP.php", {name: name}).then(function (rs1) {
            return JSON.parse(rs1);
        });
    });

}

function findP(name) {
    return $.post("service/findP.php", {name: name}).then(function (rs1) {
        return JSON.parse(rs1);
    });
}

function findPid(id, obj, path) {
    return $.post("service/findPid.php", {id: id}).then(function (rs1) {
        obj[path] = JSON.parse(rs1);
        return JSON.parse(rs1);
    });
}

function findT(name) {
    return $.post("service/findT.php", {name: name}).then(function (rs1) {
        return JSON.parse(rs1);
    });
}

function findMbyT(id) {
    return $.post("service/findMbyT.php", {id: id}).then(function (rs1) {
        return JSON.parse(rs1);
    });
}

function loadT() {
    return $.post("service/findT.php").then(function (rs1) {
        return JSON.parse(rs1);
    });
}

