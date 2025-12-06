jmeter -n -t load_savora.jmx

jmeter -n -t load_savora.jmx -Jduration=10 -Juser_count=10

jmeter -g summary.csv -o report

jmeter -n –t load_savora.jmx -Jload_profile="const(10,10s) line(10,100,1m) step(5,25,5,1h)" -Jduration=100

jmeter -n -t load.jmx -l summary.csv -e -o path_to_web_report_folder
