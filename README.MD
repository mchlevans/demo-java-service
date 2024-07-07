# Java API
This is the Java API (and Postgres configuration) used in the [demo analytics dashboard](http://analyticsloadbalancer-1260159310.us-east-1.elb.amazonaws.com)!

Not all code in this repo is used directly in the analytics dashboard. Some code I'm using for my own development purposes, and I expect to add additional code for new datasets, which may or may not be deployed in the dashboard as of writing this.

This service can be built and run locally with Docker and Docker Compose. The script ```scripts/buildApiImage.sh``` builds the Java API image and the script ```scripts/buildDbImage.sh``` builds the Postgres image. When performing local development with live reloading in the [analytics service](https://github.com/mchlevans/demo-analytics-service), the environment variable ```ANALYTICS_SERVICE_URL``` should be pointed to the applicable port on the host machine using ```host.docker.internal```.
