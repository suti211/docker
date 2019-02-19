DB CONFIG:

Docker database will recieve the following environment variables from the .env file located in the project root,
next to the docker-compose.yaml

On the first run of the image, mysql will init in the container, and the initial config and data state will be saved
in a shared folder named "data". these environment variables play a role on the first db init. This means that, when you
modify any of tese environment variables you must delete the data directory while the db container is stopped,
because the Db image reads these variables during the init cycle.

MYSQL_ROOT_PASSWORD=root  -- this will set the password of the root user
MYSQL_USER=username       -- this will create a superadmin user with the specified username
MYSQL_PASSWORD=password	  -- this will be the password of the user mentioned above
MYSQL_DATABASE=manager	  -- this will create a db scheme with the specified name on init

YOU NEED TO SET UP THESE VARIABLES IN YOUR .ENV FILE!