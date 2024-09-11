$1 = Get-WinUserLanguageList
$1.Add('de-DE')
Set-WinUserLanguageList $1 -Force

$1 = Get-WinUserLanguageList
$1.RemoveAll( { $args[0].LanguageTag -clike 'de*' } )
Set-WinUserLanguageList $1 -Force