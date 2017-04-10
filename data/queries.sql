/* Hoeveel fietsen worden met geweld gestolen? */
SELECT COUNT(*)
FROM bicycle_thefts
WHERE mk_omschrijving
LIKE 'DIEFSTAL MET GEWELD%';

/* Hoeveel fietsdiefstallen zijn er getelt per soort diefstal? */
SELECT COUNT(*), mk_omschrijving
FROM bicycle_thefts
WHERE plaats = 'ROTTERDAM'
GROUP BY mk_omschrijving;

/* Op welke datum zijn de meeste fietsen gestolen? */
SELECT COUNT(*) AS count, kennisname
FROM bicycle_thefts
GROUP BY kennisname
ORDER BY count DESC;

/* Om welke tijd worden de meeste fietsen gestolen? */
SELECT COUNT(*) AS count, begintijd
FROM bicycle_thefts
GROUP BY begintijd
ORDER BY count DESC;

/* Waar kan je je fiets het veiligst stallen in Rotterdam? */
SELECT COUNT(*) AS count, bs.street, bs.latitude, bs.longitude
FROM bicycle_thefts AS bt
INNER JOIN bicycle_stalls AS bs
ON bs.street = bt.straat AND bt.plaats = 'ROTTERDAM' AND bs.latitude <> 0.0 AND bs.longitude <> 0.0
GROUP BY bs.street, bs.latitude, bs.longitude
ORDER BY count ASC;