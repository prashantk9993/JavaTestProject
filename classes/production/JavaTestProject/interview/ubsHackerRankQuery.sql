select * from (
select 'SaaS' as service_type,
p.name as service_name,
sum(p.price_per_second) as price_per_second,
sum(pu.usage_seconds) as total_usage,
sum(p.price_per_second * pu.usage_seconds) || '$' as total_cost
from paas p
left outer join paas_usage pu
on p.id = pu.service_id
group by service_type,service_name

UNION

select 'PaaS' as service_type,
p.name as service_name,
sum(p.price_per_second) as price_per_second,
sum(pu.usage_seconds) as total_usage,
sum(p.price_per_second * pu.usage_seconds) || '$' as total_cost
from saas p
left outer join saas_usage pu
on p.id = pu.service_id
group by service_type,service_name
) temp1 order by service_type , service_name ;