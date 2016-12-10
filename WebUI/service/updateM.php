<?php
extract($_GET);
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/match/" . $id);
curl_setopt($ch, CURLOPT_PUTFIELDS, "winnerId=" . $w . "&matchScore=" . $s);
curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded'));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$result = curl_exec($curl);
curl_close($curl);
print($result);
?>