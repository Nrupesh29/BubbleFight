<?php
extract($_POST);
if (isset($name) && isset($p1) && isset($p2) && isset($p3) && isset($p4)) {
    echo "good";

} else {
    echo "error";
}

?>