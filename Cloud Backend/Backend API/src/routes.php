<?php
// Routes

//***************************//
//    TOURNAMENT API CALLS   //
//***************************//

// get all tournaments
$app->get('/tournaments', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM tournament");
    $sth->execute();
    $tournaments = $sth->fetchAll();
    return $this->response->withJson($tournaments);
});

// retrieve tournament with id
$app->get('/tournament/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM tournament WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $tournaments = $sth->fetchObject();
    return $this->response->withJson($tournaments);
});

// Search for tournament with given search term in their name
$app->get('/tournament/search/[{query}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM tournament WHERE UPPER(name) LIKE :query ORDER BY name");
    $query = "%".$args['query']."%";
    $sth->bindParam("query", $query);
    $sth->execute();
    $tournaments = $sth->fetchAll();
    return $this->response->withJson($tournaments);
});

// Add a new tournament
$app->post('/tournament', function ($request, $response) {
    $input = $request->getParsedBody();
    $sql = "INSERT INTO tournament (name, maxplayers) VALUES (:name, :maxplayers)";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("name", $input['name']);
    $sth->bindParam("maxplayers", $input['maxplayers']);
    $sth->execute();
    $input['id'] = $this->db->lastInsertId();
    return $this->response->withJson($input);
});

// DELETE a tournament with given id
$app->delete('/tournament/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("DELETE FROM tournament WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $sth = $this->db->prepare("SELECT * FROM tournament");
    $sth->execute();
    $tournaments = $sth->fetchAll();
    return $this->response->withJson($tournaments);
});

// Update tournament with given id
$app->put('/tournament/[{id}]', function ($request, $response, $args) {
    $input = $request->getParsedBody();
    $sql = "UPDATE tournament SET name=:name, maxplayers=:maxplayers WHERE id=:id";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("id", $args['id']);
    $sth->bindParam("name", $input['name']);
    $sth->bindParam("maxplayers", $input['maxplayers']);
    $sth->execute();
    $input['id'] = $args['id'];
    return $this->response->withJson($input);
});


//***************************//
//      PLAYER API CALLS     //
//***************************//

// get all players
$app->get('/players', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM player");
    $sth->execute();
    $players = $sth->fetchAll();
    return $this->response->withJson($players);
});

// retrieve player with id
$app->get('/player/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM player WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $players = $sth->fetchObject();
    return $this->response->withJson($players);
});

// Search for player with given search term in their name
$app->get('/player/search/[{query}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM player WHERE UPPER(name) LIKE :query ORDER BY name");
    $query = "%".$args['query']."%";
    $sth->bindParam("query", $query);
    $sth->execute();
    $players = $sth->fetchAll();
    return $this->response->withJson($players);
});

// Add a new player
$app->post('/player', function ($request, $response) {
    $input = $request->getParsedBody();
    $sql = "INSERT INTO player (name) VALUES (:name)";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("name", $input['name']);
    $sth->execute();
    $input['id'] = $this->db->lastInsertId();
    return $this->response->withJson($input);
});

// DELETE a player with given id
$app->delete('/player/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("DELETE FROM player WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $sth = $this->db->prepare("SELECT * FROM player");
    $sth->execute();
    $players = $sth->fetchAll();
    return $this->response->withJson($players);
});

// Update player with given id
$app->put('/player/[{id}]', function ($request, $response, $args) {
    $input = $request->getParsedBody();
    $sql = "UPDATE player SET name=:name WHERE id=:id";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("id", $args['id']);
    $sth->bindParam("name", $input['name']);
    $sth->execute();
    $input['id'] = $args['id'];
    return $this->response->withJson($input);
});


//***************************//
//      LEVEL API CALLS      //
//***************************//

// get all levels
$app->get('/levels', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM level");
    $sth->execute();
    $levels = $sth->fetchAll();
    return $this->response->withJson($levels);
});

// retrieve level with id
$app->get('/level/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM level WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $levels = $sth->fetchObject();
    return $this->response->withJson($levels);
});

// Search for level with given search term in their name
$app->get('/level/search/[{query}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM level WHERE UPPER(name) LIKE :query ORDER BY name");
    $query = "%".$args['query']."%";
    $sth->bindParam("query", $query);
    $sth->execute();
    $levels = $sth->fetchAll();
    return $this->response->withJson($levels);
});

// Add a new level
$app->post('/level', function ($request, $response) {
    $input = $request->getParsedBody();
    $sql = "INSERT INTO level (name) VALUES (:name)";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("name", $input['name']);
    $sth->execute();
    $input['id'] = $this->db->lastInsertId();
    return $this->response->withJson($input);
});

// DELETE a level with given id
$app->delete('/level/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("DELETE FROM level WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $sth = $this->db->prepare("SELECT * FROM level");
    $sth->execute();
    $levels = $sth->fetchAll();
    return $this->response->withJson($levels);
});

// Update level with given id
$app->put('/level/[{id}]', function ($request, $response, $args) {
    $input = $request->getParsedBody();
    $sql = "UPDATE level SET name=:name WHERE id=:id";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("id", $args['id']);
    $sth->bindParam("name", $input['name']);
    $sth->execute();
    $input['id'] = $args['id'];
    return $this->response->withJson($input);
});


//***************************//
//      MATCH API CALLS      //
//***************************//

// get all matches
$app->get('/matches', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM matches");
    $sth->execute();
    $matches = $sth->fetchAll();
    return $this->response->withJson($matches);
});

// retrieve match with id
$app->get('/match/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM matches WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $matches = $sth->fetchObject();
    return $this->response->withJson($matches);
});

// retrieve all matchs with Tournament id
$app->get('/match-tournament/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("SELECT * FROM matches WHERE tournament_id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $matches = $sth->fetchAll();
    return $this->response->withJson($matches);
});

// Add a new match
$app->post('/match', function ($request, $response) {
    $input = $request->getParsedBody();
    $sql = "INSERT INTO matches (player_one_id, player_two_id, tournament_id, level_id, winner_id, matchdate, score) VALUES (:playerOneId, :playerTwoId, :tournamentId, :levelId, :winnerId, :matchDate, :matchScore)";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("playerOneId", $input['playerOneId']);
    $sth->bindParam("playerTwoId", $input['playerTwoId']);
    $sth->bindParam("tournamentId", $input['tournamentId']);
    $sth->bindParam("levelId", $input['levelId']);
    $sth->bindParam("winnerId", $input['winnerId']);
    $sth->bindParam("matchDate", $input['matchDate']);
    $sth->bindParam("matchScore", $input['matchScore']);
    $sth->execute();
    $input['id'] = $this->db->lastInsertId();
    return $this->response->withJson($input);
});

// DELETE a match with given id
$app->delete('/match/[{id}]', function ($request, $response, $args) {
    $sth = $this->db->prepare("DELETE FROM matches WHERE id=:id");
    $sth->bindParam("id", $args['id']);
    $sth->execute();
    $sth = $this->db->prepare("SELECT * FROM matches");
    $sth->execute();
    $tournaments = $sth->fetchAll();
    return $this->response->withJson($tournaments);
});

// Update match with given id
$app->put('/match/[{id}]', function ($request, $response, $args) {
    $input = $request->getParsedBody();
    $sql = "UPDATE matches SET winner_id=:winnerId, score=:matchScore WHERE id=:id";
    $sth = $this->db->prepare($sql);
    $sth->bindParam("id", $args['id']);
    $sth->bindParam("winnerId", $input['winnerId']);
    $sth->bindParam("matchScore", $input['matchScore']);
    $sth->execute();
    $input['id'] = $args['id'];
    return $this->response->withJson($input);
});
