<?php

require_once "../config/db.php";

$q = "SELECT * from `post` where `userId` = :userId";

if (isset($_GET['userId'])) {
    $userId = $_GET['userId'];
    $stmt = $conn->prepare($q);
    $stmt->bindParam("userId", $userId);

    if (!$stmt->execute()) {
        $response[STATUS] = "error";
        $response[MESSAGE] = "query error";
        echo json_encode($response);
        exit;
    }


    $posts = array();

    while ($post = $stmt->fetchObject()) {
        array_push($posts, $post);
    }

    $response[STATUS] = "success";
    $response[MESSAGE] = $posts;

    echo json_encode($response);
} else {
    $response[STATUS] = "error";
    $response[MESSAGE] = "id missing";
    echo json_encode($response);
    exit;
}
