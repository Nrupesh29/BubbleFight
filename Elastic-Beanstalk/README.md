# Game API Calls

[//]: # (Base Url : http://sample-env.xtfzxnrydy.us-west-1.elasticbeanstalk.com/api/)

### Tournament API Calls

| Request | Endpoint     | Parameters |Description                 |
|---------|--------------|------------- | -----------------------------|
| GET     | `{base_url}/tournaments` | | List all tournaments |
| GET     | `{base_url}/tournament/{id}` | | List tournament with specified **`id`** |
| GET     | `{base_url}/tournament/search/{term}` | | List tournament with name containing specified **`term`** |
| POST     | `{base_url}/tournament`| `name` <br /> `maxplayers` | Add a new tournament |
| DELETE     | `{base_url}/tournament/{id}` | | Delete tournament with specified **`id`** |
| PUT     | `{base_url}/tournament/{id}`| `name` <br /> `maxplayers` | Update tournament with specified **`id`** |
