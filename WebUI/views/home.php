<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <paper-card class="col-xs-12" heading="Home" alt="Home">
            </paper-card>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-xs-6">
            <paper-card class="col-xs-12" heading="Latest Normal Battles" alt="Latest Normal Battles">
                <div class="tool-bar">
                    <iron-icon class="cl-green" icon="icons:thumb-up" item-icon></iron-icon>
                </div>
                <div class="card-content">
                    <table class="table">
                        <thead>
                        <th>#</th>
                        <th>Score</th>
                        <th>Date time</th>
                        </thead>
                        <?php 
                            $ch = curl_init('http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/match-tournament/0');
                            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                            // execute the api call
                            $result = curl_exec($ch);
                            // display the json response
                            $result_array = json_decode($result, true);

                            $arr = array_reverse(array_slice($result_array, -5));

                            foreach ($arr as &$value) {
                                echo'<tr>
                                        <td>'.$value['id'].'</td>
                                        <td>'.$value['score'].'</b></td>
                                        <td>'.$value['matchdate'].'</td>
                                    </tr>';
                            }
                              
                        ?>
                    </table>
                </div>
            </paper-card>

        </div>
        <div class="col-xs-6">
            <paper-card class="col-xs-12" heading="Normal Battle Win" alt="Normal Battle Win">
                <div class="tool-bar">
                    <iron-icon class="cl-green" icon="icons:stars" item-icon></iron-icon>
                </div>
                <div class="card-content">
                    <table class="table">
                        <thead>
                        <th></th>
                        <th>Wins</th>
                        </thead>
                        <tbody>
                        <tr>
                            <th>Player 1</th>
                            <td>0</td>
                        </tr>
                        <tr>
                            <th>Player 2</th>
                            <td>0</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </paper-card>

        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-xs-12">

            <paper-card class="col-xs-12" heading="Latest Tournament Battles" alt="Latest Tournament Battles">
                <div class="tool-bar">
                    <iron-icon class="cl-green" icon="icons:event-seat" item-icon></iron-icon>
                </div>
                <div class="card-content">
                    <table class="table">
                        <thead>
                        <th>#</th>
                        <th>name</th>
                        <th>1st place</th>
                        <th>2nd place</th>
                        <th>3rd place</th>
                        <th>3rd place</th>
                        <th>Date time</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td><b>T1</b></td>
                            <td>P1</td>
                            <td>P2</td>
                            <td>P3</td>
                            <td>P4</td>
                            <td>10/11/2016 10:00:00</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td><b>T1</b></td>
                            <td>P1</td>
                            <td>P2</td>
                            <td>P3</td>
                            <td>P4</td>
                            <td>10/11/2016 10:00:00</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </paper-card>
        </div>
    </div>
</div>