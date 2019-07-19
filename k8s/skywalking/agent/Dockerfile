FROM apache/skywalking-base:6.2.0
RUN cd skywalking && rm -r config oap-libs webapp
# 设置时区
RUN ln -fs /usr/share/zoneinfo/Asia/Shanghai /etc/localtime