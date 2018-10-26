#此文件是在 一键工具 .c -> .so 时使用
#相关注释 来自博客 https://blog.csdn.net/csdn49532/article/details/47723019
#其他未使用的参数 参考 https://blog.csdn.net/roland_sun/article/details/46318893
#目标Android版本
APP_PLATFORM = android-19
#编译成什么类型的cpu的so, 拥有三个属性armeabi  armeabi-v7a  x86
#可以全选 也可以只用一个，如果全选也可以使用all  (包括了arm64-v8a,armeabi-v7a,x86,x64_64),已经不再支持armeabi版
APP_ABI := all
#编译版本，如果是DEBUG版本就会带上调试信息。可以使用gdb-server进行动态断点低调试。
#debug:调试版本-so中带调试信息
#release:发布版本-so不带调试信息
APP_OPTIM := debug