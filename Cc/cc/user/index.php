<?php

require_once "../config/db.php";

$q_single = "SELECT * from `user` where `id` = :id";
$q_all = "SELECT * from `user`";
$q_main = "";


if (isset($_GET['id'])) {
    $userId = $_GET['id'];
    $q_main = $q_single;
    $stmt = $conn->prepare($q_main);
    $stmt->bindParam(":id", $userId);
} else {
    $q_main = $q_all;
    $stmt = $conn->prepare($q_main);
}




if (!$stmt->execute()) {
    $response[STATUS] = "error";
    $response[MESSAGE] = "query error";
    echo json_encode($response);
    exit;
}




$users = array();

while ($user = $stmt->fetchObject()) {
    array_push($users, $user);
}

$response[STATUS] = "success";
$response[MESSAGE] = $users;

echo json_encode($response);
