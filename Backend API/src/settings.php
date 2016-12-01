<?php
return [
    'settings' => [
        'displayErrorDetails' => true, // set to false in production
        'addContentLengthHeader' => false, // Allow the web server to send the content-length header

        // Renderer settings
        'renderer' => [
            'template_path' => __DIR__ . '/../templates/',
        ],

        // Monolog settings
        'logger' => [
            'name' => 'slim-app',
            'path' => __DIR__ . '/../logs/app.log',
            'level' => \Monolog\Logger::DEBUG,
        ],

        // Database connection settings
        "db" => [
            "host" => $_SERVER['RDS_HOSTNAME'],
            "dbname" => $_SERVER['RDS_DB_NAME'],
            "user" => $_SERVER['RDS_USERNAME'],
            "pass" => $_SERVER['RDS_PASSWORD']
        ],
    ],
];
