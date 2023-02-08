# ReplayModFixMod
[EN](https://github.com/wohaopa/ReplayModFixMod)
中

用于修复ReplayMod无法在GTNH中运行的mod。因为ReplayMod时间久远，构建项目复杂。我无法重新构建它，于是制作了这个mod。
## 当前问题：
1. 游戏中手部无法正常显示
2. 游戏中菜单按钮无法正常切换
3. 回放时无法实体渲染问题
4. 回放时UI问题
5. Mixin冲突(解决)
6. 无法进入回放(解决)
## 说明
在GTNH中使用ReplayMod遇到问题请在本项目中反馈。
## 使用方法
下载ReplayMod 2.5.2版本。使用压缩软件打开，替换`com\replaymod\core\tweaker\ReplayModTweaker.class`为[ReplayModTweaker.class](https://github.com/wohaopa/ReplayModFixMod/replace/ReplayModTweaker.class) 将本mod与replaymod一并放入至mods文件夹。下载并安装[ffmpeg](https://www.gyan.dev/ffmpeg/builds/packages/ffmpeg-5.1.2-essentials_build.zip)至`.minecraft`目录即可。