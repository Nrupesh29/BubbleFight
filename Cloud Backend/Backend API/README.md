# Game API Calls

### Tournament API Calls

| Request | Endpoint     | Parameters |Description                 |
|---------|--------------|------------- | -----------------------------|
| GET     | `{base_url}/tournaments` | | List all tournaments |
| GET     | `{base_url}/tournament/{id}` | | List tournament with specified **`id`** |
| GET     | `{base_url}/tournament/search/{term}` | | List tournament with name containing specified **`term`** |
| POST     | `{base_url}/tournament`| `name` <br /> `maxplayers` | Add a new tournament |
| DELETE     | `{base_url}/tournament/{id}` | | Delete tournament with specified **`id`** |
| PUT     | `{base_url}/tournament/{id}`| `name` <br /> `maxplayers` | Update tournament with specified **`id`** |


### Player API Calls

| Request | Endpoint     | Parameters |Description                 |
|---------|--------------|------------- | -----------------------------|
| GET     | `{base_url}/players` | | List all players |
| GET     | `{base_url}/player/{id}` | | List player with specified **`id`** |
| GET     | `{base_url}/player/search/{term}` | | List player with name containing specified **`term`** |
| POST     | `{base_url}/player`| `name` | Add a new player |
| DELETE     | `{base_url}/player/{id}` | | Delete player with specified **`id`** |
| PUT     | `{base_url}/player/{id}`| `name` | Update player with specified **`id`** |


### Level API Calls

| Request | Endpoint     | Parameters |Description                 |
|---------|--------------|------------- | -----------------------------|
| GET     | `{base_url}/levels` | | List all levels |
| GET     | `{base_url}/level/{id}` | | List level with specified **`id`** |
| GET     | `{base_url}/level/search/{term}` | | List level with name containing specified **`term`** |
| POST     | `{base_url}/level`| `name` | Add a new level |
| DELETE     | `{base_url}/level/{id}` | | Delete level with specified **`id`** |
| PUT     | `{base_url}/level/{id}`| `name` | Update level with specified **`id`** |


### Match API Calls

| Request | Endpoint     | Parameters |Description                 |
|---------|--------------|------------- | -----------------------------|
| GET     | `{base_url}/matches` | | List all matches |
| GET     | `{base_url}/match/{id}` | | List match with specified **`id`** |
| POST     | `{base_url}/match`| `playerOneId` <br /> `playerTwoId` <br /> `tournamentId` <br /> `levelId` <br /> `winnerId` | Add a new match |
| DELETE     | `{base_url}/match/{id}` | | Delete match with specified **`id`** |
| PUT     | `{base_url}/match/{id}`| `playerOneId` <br /> `playerTwoId` <br /> `tournamentId` <br /> `levelId` <br /> `winnerId` | Update match with specified **`id`** |



## Contributor

| [![Nrupesh Patel](https://avatars.githubusercontent.com/nrupesh29?s=100)<br /><sub>Nrupesh Patel<br />CMPE 202 - 03</sub>](https://github.com/Nrupesh29)<br /> |
| :---: |
