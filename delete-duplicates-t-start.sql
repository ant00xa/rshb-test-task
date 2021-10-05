DELETE
FROM t_start a USING (
    SELECT MIN(t_start.timestamp) as minid, t_start.app_num
    FROM t_start
    GROUP BY app_num
    HAVING COUNT(*) > 1
) b
WHERE a.app_num = b.app_num
  AND a.timestamp <> b.minid