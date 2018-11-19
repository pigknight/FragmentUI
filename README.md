# FragmentUI
一个基于Fragment的动态构建的快速UI流开发类,方便快速构建App的UI Flow.

一个典型的音乐Demo的UI架构如下:

Layer-1: --Root

Layer-2: --|--Content

Layer-3:------|--Category

Layer-3:------|--AlbumList

Layer-3:------|--MusicList

Layer-2: --|--Playing


音乐Demo运行效果:

![image](https://github.com/pigknight/FragmentUI/tree/master/demo.gif?raw=true)


示例代码:

1.设置默认UI切换动画

FragmentUI.setDefaultAnimRes(R.anim.push_right_in,R.anim.push_left_out,R.anim.push_left_in,R.anim.push_right_out);

2.初始化跟U节点

Root.initInstance(this);

3.动态显示其他UI

Root.getInstance().enterUI(Content.class);

或

Root.getInstance().findUI(Content.class).enterUI(AlbumList.class);

或

this.enterUI(AlbumList.class);

4.退出一个UI

Root.getInstance().findUI(MusicList.class).exitUI();

或

this.exitUI()


