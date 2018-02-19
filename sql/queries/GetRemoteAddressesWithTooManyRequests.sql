set @startDate = '2017-01-01.00:00:00', @endDate = '2017-01-02.00:00:00', @threshold = 500;

select remote_address ip
from access_log.request
where date >= @startDate and date < @endDate
group by remote_address
having count(*) >= @threshold;
