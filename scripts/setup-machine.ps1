Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

cinst -y git openjdk intellijidea-community

mkdir D:\tark-training
Set-Location D:\tark-training
git clone https://github.com/TarkTech/training-oops.git
