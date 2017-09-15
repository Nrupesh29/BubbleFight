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
                    <div id="target1">Loading...</div>
                    <script id="template1" type="x-tmpl-mustache">
                                    <table class="table">
                                        <thead>
                                        <th>#</th>
                                        <th>Score</th>
                                        <th>Date time</th>
                                        </thead>
                                    <tbody>
                                    {{#matches}}
                                        <tr>
                                        <td>{{index}}</td>
                                        <td>{{score}}</td>
                                        <td>{{matchdate}}</td>
                                        </tr>
                                    {{/matches}}
                                    </tbody>
                                    </table>





                    </script>
                </div>
            </paper-card>


        </div>
        <div class="col-xs-6">
            <paper-card class="col-xs-12" heading="Normal Battle Win" alt="Normal Battle Win">
                <div class="tool-bar">
                    <iron-icon class="cl-green" icon="icons:stars" item-icon></iron-icon>
                </div>
                <div class="card-content">
                    <div id="target2">Loading...</div>
                    <script id="template2" type="x-tmpl-mustache">
                    <table class="table">
                        <thead>
                        <th></th>
                        <th>Wins</th>
                        </thead>
                        <tbody>
                        <tr>
                            <th>Player 1</th>
                            <td>{{p1}}</td>
                        </tr>
                        <tr>
                            <th>Player 2</th>
                            <td>{{p2}}</td>
                        </tr>
                        </tbody>
                    </table>

                    </script>
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
<script>
    var data = {};


    window.setTimeout(function () {
        curlNormal().then(function (rs) {
            console.log(rs);
            for (var i = 0; i < rs.length; i++) {
                rs[i].index = i + 1;
            }
            console.log(rs);
            data.matches = rs;
            var template = $('#template1').html();
            Mustache.parse(template);   // optional, speeds up future uses
            var rendered = Mustache.render(template, data);
            $('#target1').html(rendered);
        });

        countNormal().then(function (rs) {
            console.log(rs);
            var template = $('#template2').html();
            Mustache.parse(template);   // optional, speeds up future uses
            var rendered = Mustache.render(template, rs);
            $('#target2').html(rendered);
        });

    }, 1000);
    //
</script>