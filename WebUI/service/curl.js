var URL = "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/";

function curlCreateTournament(name, players) {
    createP("a1");
    var url = "service/createTournament.php";
    var data = {
        name: name,
        p1: "a1",
        p2: "a2",
        p3: "a3",
        p4: "a4",
        // p1: players[0],
        // p2: players[1],
        // p3: players[2],
        // p4: players[3],
    };
    return $.post(url, data);
};

function createP(name) {
    return $.post("service/createP.php", {name: name});

}