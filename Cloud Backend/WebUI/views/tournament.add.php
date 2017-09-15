<?php
header('Access-Control-Allow-Origin: *');
?>
<form id="createTournamentForm">
    <div class="row">
        <div class="col-xs-12 col-sm-3">
        </div>
        <div class="col-xs-12 col-sm-6">
            <div class="col-xs-6">
                <input type="text" name="t-name" class="form-control" placeholder="*Enter Tournament Name" required>
            </div>
            <div class="col-xs-6">
                <paper-button class="blue" style="padding: 5px;" onclick="createTournament()" raised>
                    <iron-icon icon="icons:add"></iron-icon>
                    Add
                </paper-button>
                <paper-button class="" style="padding: 5px;" data-toggle="collapse" data-target="#addTournamentCollapse"
                              onclick="resetCreateTournament()"
                              raised>
                    <iron-icon icon="icons:close"></iron-icon>
                    Cancel
                </paper-button>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-xs-12">
            <div class="tournament-group">
                <ul>
                    <li class="item">
                        <input type="text" name="t-player" class="name" placeholder="*Enter Name" required>
                        <div class="text">
                            VS
                        </div>
                    </li>
                    <li class="item lv-2">
                        <div class="bar"></div>
                        <div class="name">Winner 1</div>
                        <div class="text">
                            VS
                        </div>
                    </li>
                    <li class="item">
                        <input type="text" name="t-player" class="name" placeholder="*Enter Name" required>
                    </li>
                    <li class="item lv-3">
                        <div class="bar"></div>
                        <div class="name">Final Winner</div>
                        <div class="image">
                            <img src="assets/images/blue-bird.png" alt="">
                            <img src="assets/images/crown.png" alt="">
                            <img src="assets/images/red-bird.png" alt="">
                        </div>
                    </li>
                    <li class="item">
                        <input type="text" name="t-player" class="name" placeholder="*Enter Name" required>
                        <div class="text">
                            VS
                        </div>
                    </li>
                    <li class="item lv-2">
                        <div class="bar"></div>
                        <div class="name">Winner 2</div>
                    </li>
                    <li class="item">
                        <input type="text" name="t-player" class="name" placeholder="*Enter Name" required>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</form>
<script>
    function createTournament() {
        if ($('#createTournamentForm')[0].checkValidity()) {
            var name = $("input[name=t-name]").val();
            var players = $("input[name=t-player]");
            for (var i = 0; i < players.length; i++) {
                players[i] = players[i].value;
            }
            console.log(name);
            console.log(players);
        }
        else {
            alert("please fill all required fields.")
        }

        curlCreateTournament(name, players).then(function(rs){
            if(rs){
                window.location.reload();
            }

        });
    }
    function resetCreateTournament() {
        $('#createTournamentForm')[0].reset();
    }
</script>