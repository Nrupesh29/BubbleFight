<?php
extract($_POST);
print_r($_POST);
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/match/" . $id);
curl_setopt($ch, CURLOPT_POSTFIELDS, "winnerId=" . $winnerId . "&matchScore=" . $score);
//curl_setopt($curl, CURLOPT_PUTFIELDS, array('winnerId' => $winnerId, 'score' => $score, 'playerOneId' => $playerOneId, 'playerTwoId' => $playerTwoId, 'tournamentId' => $tournamentId, 'levelId' => $levelId, 'matchDate' => $matchDate));
curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded'));
curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "PUT");
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

$result = curl_exec($curl);
curl_close($curl);

print($result);
?>