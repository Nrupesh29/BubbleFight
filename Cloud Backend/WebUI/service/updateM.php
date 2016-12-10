<?php

	function updateMatch($id, $w, $s) {

		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/match/" . $id);
		curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "PUT");
		curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded'));
		curl_setopt($curl, CURLOPT_POSTFIELDS, "winnerId=" . $w . "&matchScore=" . $s);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

		$result = curl_exec($curl);
		curl_close($curl);

	}

	function updateMatchFinalP1($w, $t) {
			$curl = curl_init();
			curl_setopt($curl, CURLOPT_URL, "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/match-tournament-level/" . $t);
			curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "PUT");
			curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded'));
			curl_setopt($curl, CURLOPT_POSTFIELDS, "playerOneId=" . $w);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

			$result = curl_exec($curl);
			curl_close($curl);
	}

	function updateMatchFinalP2($w, $t) {
			$curl = curl_init();
			curl_setopt($curl, CURLOPT_URL, "http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/match-tournament-level/" . $t);
			curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "PUT");
			curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/x-www-form-urlencoded'));
			curl_setopt($curl, CURLOPT_POSTFIELDS, "playerTwoId=" . $w);
			curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

			$result = curl_exec($curl);
			curl_close($curl);
	}

?>