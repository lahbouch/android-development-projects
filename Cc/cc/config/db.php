<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "cc";

header("Content-type:application/json");
define("STATUS", "status");
define("MESSAGE", "message");
$response = array();

try {
    $conn = new PDO("mysql:host=$host;dbname=$db", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    // echo "DB : OK";
} catch (PDOException $e) {
    $response[STATUS] = "error";
    $response[MESSAGE] = $e->getMessage();
    echo json_encode($response);
    exit;
}
