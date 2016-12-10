<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <paper-card class="col-xs-12" heading="Tournaments" alt="Tournaments">
                <div class="tool-bar">
                    <paper-button id="createUserModalButton" class="pull-right blue"
                                  data-toggle="collapse" data-target="#addTournamentCollapse"
                                  raised>
                        <!--                        <iron-icon icon="icons:add"></iron-icon>-->
                        New Tournament

                    </paper-button>
                </div>
                <div class="card-content collapse" id="addTournamentCollapse">
                    <?php
                    include "views/tournament.add.php";
                    ?>
                </div>
            </paper-card>
        </div>
    </div>
    <br>

    <div id="target">Loading...</div>
    <script id="template" type="x-tmpl-mustache">
    {{#tournaments}}
    <div class="row">
        <div class="col-xs-12">
            <paper-card class="col-xs-12 tournament-wrapper" >
            <h2>{{name}}</h4>
                <div class="tool-bar">
                    <h4 class="status">Status</h4>
                </div>
                <div class="card-content">
                    <div class="tournament-group">
                        <ul>
                            <li class="item">
                                <div class="name">{{matches.semi.0.player1.name}}</div>
                                <div class="text">
                                    {{#matches.semi.0.winner_id}}
                                    {{matches.semi.0.score}}
                                    {{/matches.semi.0.winner_id}}
                                    {{^matches.semi.0.winner_id}}
                                    VS
                                    {{/matches.semi.0.winner_id}}
                                </div>
                                <div class="next"><a href="javascript:void(0)" onclick="goNext({{id}},{{matches.semi.0.id}},{{matches.semi.0.player1.id}})"><i class="fa fa-caret-right"></i></a></div>
                            </li>
                            <li class="item lv-2">
                                <div class="bar"></div>
                                <div  class="name">{{matches.final.player1.name}}</div>
                                <div class="text">
                                    {{#matches.final.winner_id}}
                                    {{matches.final.score}}
                                    {{/matches.final.winner_id}}
                                    {{^matches.final.winner_id}}
                                    VS
                                    {{/matches.final.winner_id}}
                                </div>
                                <div class="next"><a href=""><i class="fa fa-caret-right"></i></a></div>
                            </li>
                            <li class="item">
                                <div  class="name">{{matches.semi.0.player2.name}}</div>
                                <div class="next"><a href=""><i class="fa fa-caret-right"></i></a></div>
                            </li>
                            <li class="item lv-3">
                                <div class="bar"></div>
                                <div class="name">
                                    {{#matches.final.winner_id}}
                                        {{matches.final.winner.name}}
                                    {{/matches.final.winner_id}}
                                    {{^matches.final.winner_id}}
                                    FINAL WINNER
                                    {{/matches.final.winner_id}}
                                </div>
                                <div class="image">
                                    <img src="assets/images/blue-bird.png" alt="">
                                    <img src="assets/images/crown.png" alt="">
                                    <img src="assets/images/red-bird.png" alt="">
                                </div>
                            </li>
                            <li class="item">
                                <div class="name">{{matches.semi.1.player1.name}}</div>
                                <div class="text">
                                      {{#matches.semi.1.winner_id}}
                                    {{matches.semi.1.score}}
                                    {{/matches.semi.1.winner_id}}
                                    {{^matches.semi.1.winner_id}}
                                    VS
                                    {{/matches.semi.1.winner_id}}
                                </div>
                                <div class="next"><a href=""><i class="fa fa-caret-right"></i></a></div>
                            </li>
                            <li class="item lv-2">
                                <div class="bar"></div>
                                <div class="name">{{matches.final.player2.name}}</div>
                                <div class="next"><a href=""><i class="fa fa-caret-right"></i></a></div>
                            </li>
                            <li class="item">
                                <div class="name">{{matches.semi.1.player2.name}}</div>
                                <div class="next"><a href=""><i class="fa fa-caret-right"></i></a></div>
                            </li>
                        </ul>
                    </div>
                </div>
            </paper-card>
        </div>
    </div>
{{/tournaments}}










    </script>
    <script>
        var data = {};


        window.setTimeout(function () {
            curlLoadTournament().then(function (rs) {
                console.log(rs);
                window.setTimeout(function () {
                    data.tournaments = rs;
                    var template = $('#template').html();
                    Mustache.parse(template);   // optional, speeds up future uses
                    var rendered = Mustache.render(template, data);
                    $('#target').html(rendered);
                }, 1000);
            });
        }, 1000);

        function goNext(t, m, p) {
            console.log(p, m);
//            curlUpdateScore
            console.log(data);
            data.tournaments.forEach(function (tour) {
                console.log(tour);
                var find = null;
                if (tour.id == t) {
                    if (tour.matches.semi[0].id == m) {
                        find = tour.matches.semi[0];
                    }
                    if (tour.matches.semi[1].id == m) {
                        find = tour.matches.semi[1];
                    }
                    if (tour.matches.final.id == m) {
                        find = tour.matches.final;
                    }

                    if (find) {
                        return curlUpdateScore({
                            id: find.id,
                            winnerId: p,
                            score: find.player_one_id == p ? "3 - 0" : "0 - 1",
                            playerOneId: find.player_one_id,
                            playerTwoId: find.player_two_id,
                            tournamentId: find.tournament_id,
                            levelId: find.level_id,
                            matchDate: find.matchdate
                        }).then(function (rs) {
                            console.log(rs);
                        });
                    }

                }
            });
        }
        //
    </script>

</div>