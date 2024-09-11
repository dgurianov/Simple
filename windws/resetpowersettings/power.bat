:loop

Powercfg /Change monitor-timeout-dc 0
Powercfg /Change monitor-timeout-ac 0

Powercfg /Change hibernate-timeout-ac 0
Powercfg /Change hibernate-timeout-ac 0

Powercfg /Change standby-timeout-ac 0
Powercfg /Change standby-timeout-ac 0

timeout /t 10800 /nobreak

goto loop



