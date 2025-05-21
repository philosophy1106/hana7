#!/bin/bash

docker-compose up -d

sleep 2

mysql -uroot -p646579 -h 127.0.0.1 -P 3309 -e "SET GLOBAL innodb_optimize_fulltext_only = ON;"
mysql -uroot -p646579 -h 127.0.0.1 -P 3309 -e "OPTIMIZE TABLE testdb.Notice;"
mysql -uroot -p646579 -h 127.0.0.1 -P 3309 -e "SET GLOBAL innodb_optimize_fulltext_only = OFF;"
mysql -uroot -p646579 -h 127.0.0.1 -P 3309 -e "set global innodb_ft_aux_table = 'testdb/Notice';"
