var URL = "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/";

function curlCreateTournament(name) {
    var url = URL + "tournament";
    var data = {
        name: name,
        maxplayers: 4
    };
    $.post(url, data);
};