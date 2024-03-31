mvn clean package
docker tag 054a2dbdbc63 registry.cn-hangzhou.aliyuncs.com/libre/libre:1.0
docker push registry.cn-hangzhou.aliyuncs.com/libre/libre:1.0


#数据库连接
#ssh -i "libre.pem" -f -N -L 2345:database-1.cr6saacm68mo.ap-southeast-1.rds.amazonaws.com:5432 root@ec2-13-250-118-103.ap-southeast-1.compute.amazonaws.com -v
