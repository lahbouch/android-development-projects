<?php

require_once "../config/db.php";

$response = array();


if (isset($_POST["title"]) && isset($_POST['description']) && isset($_POST['userId']) && count($_POST) == 3) {

    $title = $_POST["title"];
    $description = $_POST['description'];
    $userId = $_POST['userId'];

    $q = "INSERT INTO `post` (title, description,userId)
    VALUES (:title, :description,:userId)";

    $stmt = $conn->prepare($q);

    $stmt->bindParam(":title", $title, PDO::PARAM_STR);
    $stmt->bindParam(":description", $description, PDO::PARAM_STR);
    $stmt->bindParam(":userId", $userId, PDO::PARAM_INT);



    try {
        if (!$stmt->execute()) {
            $response[STATUS] = "error";
            $response[MESSAGE] = "query error";
            echo json_encode($response);
            exit;
        }
    } catch (PDOException $e) {
        $response[STATUS] = "error";
        $response[MESSAGE] = $e->getMessage();
        echo json_encode($response);
        exit;
    }

    $response[STATUS] = "success";
    $response[MESSAGE] = "post added";
    echo json_encode($response);
} else {
    $response[STATUS] = "error";
    $response[MESSAGE] = "params missing";
    echo json_encode($response);
}
