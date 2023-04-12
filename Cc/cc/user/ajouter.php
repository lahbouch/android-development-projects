<?php

require_once "../config/db.php";

header("Content-type:application/json");
define("STATUS", "status");
define("MESSAGE", "message");
$response = array();


if (isset($_POST["username"]) && isset($_POST['email']) && count($_POST) == 2) {

    $username = $_POST["username"];
    $email = $_POST['email'];

    $q = "INSERT INTO `user` (username, email)
    VALUES (:username, :email)";

    $stmt = $conn->prepare($q);

    $stmt->bindParam(":username", $username, PDO::PARAM_STR);
    $stmt->bindParam(":email", $email, PDO::PARAM_STR);



    if (!$stmt->execute()) {
        $response[STATUS] = "error";
        $response[MESSAGE] = "query error";
        echo json_encode($response);
        exit;
    }

    $response[STATUS] = "success";
    $response[MESSAGE] = "user added";
    echo json_encode($response);
} else {
    $response[STATUS] = "error";
    $response[MESSAGE] = "params missing";
    echo json_encode($response);
}
