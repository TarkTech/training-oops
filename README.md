# training-oops

Examples to demonstrate OOPS, Algorithms &amp; Data Structures

## Setup Machine

##### video link : _video link here of setup video v2(script version)_

#### Steps to follow

1. Open powershell in admin mode.
2. Run following commands in powershell window (in same sequence):
3. After running 1st command you will enter "Y" and then press enter

_Right click in the powershell window to paste. Hit enter key to run after pasting the command in powershell window._

```
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
Set-Location $env:TEMP
iwr https://raw.githubusercontent.com/TarkTech/training-oops/main/scripts/setup-machine.ps1 -Outfile setup-machine.ps1
.\setup-machine.ps1
```

4. You'd see a message stating "Setup Completed." at the end. Once completed, you can find `D:\tark-training` directory.
5. You may want to follow the video link, for seamless setup process.

##### If you are unable to setup through above video, here is another detailed video link: _video link here of v1_

##### if you are getting error of `java not recognized as internal command` follow link : _java error solving video link_
