set b=%~dp0
set d=%~d0
%d%
cd %b%
mvn eclipse:eclipse -DdownloadSources=true