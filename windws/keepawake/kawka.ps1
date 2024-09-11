$wsh = New-Object -ComObject WScript.Shell
while (1) {
#[System.Windows.Forms.Cursor]::Position = New-Object System.Drawing.Point(((($Pos.X) + 1), $Pos.Y)
    $wsh.SendKeys('+{F15}')
    Start-Sleep -seconds 5
    echo Click!
}-Force