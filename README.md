# training-oops

Examples to demonstrate OOPS, Algorithms &amp; Data Structures

## Setup Tools & Projects
### Using Powershell Script (Preferred)
Please follow instructions as specified in the [tutorial video.](https://www.youtube.com/watch?v=los5j8Sw80U)

For your reference, the commands used in the video are specified below.
```shell
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass

Set-Location $env:TEMP

iwr https://raw.githubusercontent.com/TarkTech/training-oops/main/scripts/setup-machine.ps1 -Outfile setup-machine.ps1

.\setup-machine.ps1

git clone https://github.com/TarkTech/training-oops.git
```
### Manual Installation
In case, if you are unable to install using Powershell script, please follow the steps mentioned [here.](https://www.youtube.com/watch?v=E0HHr6C0MzE)

**Note:** Please try this option, only if you are unable to install using Powershell script.
For your reference, the commands and links, used in the video, are listed below.
```shell
Install Git: https://git-scm.com/download/win 

Clone Git Repository: git clone https://github.com/TarkTech/training-oops.git 

Install JDK 17:  https://docs.microsoft.com/en-us/java/openjdk/download 

Install Intellij (Community Edition): https://www.jetbrains.com/idea/download/#section=windows

```

### Troubleshooting

**Q:** While running `java -version` in command prompt, I'm getting an error like `java not recognized as internal command`

**A:** Add/Update environment variables, as mentioned below.

Add new system environment variable `JAVA_HOME` pointing to JDK 17 installation directory. For example, `C:\Program Files\Microsoft\jdk-17.0.2.8-hotspot`

Update`PATH` environment variable by appending `%JAVA_HOME%\bin` 

