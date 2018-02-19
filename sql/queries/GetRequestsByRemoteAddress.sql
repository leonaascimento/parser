set @ip = '192.168.102.136';

select date, remote_address ip, method request, response_status status, user_agent
from access_log.request
where remote_address = @ip;
