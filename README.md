# ReplayModFixMod
EN
[中](https://github.com/wohaopa/ReplayModFixMod/blob/master/README_CN.md)

**The following content is translated by machine**

Used to fix mods where ReplayMod does not work in GTNH. Because ReplayMod is so old, building projects are complicated. I couldn't rebuild it, so I made this mod.

## Current Issues:
1. Hands cannot be displayed normally in the game (**resolved** after GTNH 2.3.2)
3. Menu buttons cannot be switched normally in the game
4. Cannot render entity during replay
5. UI issues during replay
6. Mixin Conflict (resolved)
7. Unable to access replay (resolved)
## Description
If you have any problems using ReplayMod in GTNH, please give feedback in this project.
## How to use
Download ReplayMod 2.5.2. Use compression software to open, replace `com\replaymod\core\tweaker\ReplayModTweaker.class` with [ReplayModTweaker.class](https://github.com/wohaopa/ReplayModFixMod/blob/master/replace/ReplayModTweaker.class) and put this mod and replaymod in the mods folder. Download and install directories [ffmpeg](https://www.gyan.dev/ffmpeg/builds/packages/ffmpeg-5.1.2-essentials_build.zip) through `.minecraft`.
For GTNH after 2.3.2, you need to delete the `org` directory in replaymod.jar.
 
