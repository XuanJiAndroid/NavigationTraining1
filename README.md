# Android Navigation 架构组件入门教程
## 前言
 Navigation组件是AndroidStudio3.3.0版本更新带来的新组件，其特点是在一个Activity中使用多个Fragment处理平滑用户操作，且可以统一进场，退场，弹出，隐藏动画，可视化处理Action，支持深层链接(不在同一个Activity时可以弹出跳转，底层是BroadcastReceiver),支持以少量代码连接底部导航或者连接ActionBar菜单或者连接Drawlayout的MenuItem，且导航时提供了类型安全(SafeArgs)。好处说了那么多，下面咱们来看看具体如何使用吧！
 
## 教程下载
[教程github](https://github.com/XuanJiAndroid/NavigationTraining1)

## 你需要知道
关于Navigation你需要知道如下三个组件
### Navigation graph
这是Navigation的导航图，位于`res/navigation/`目录下的xml文件，
其有两个模式，`Design`(可视化设计模式)和`Text`(文字模式)，在`Design`可视化环境下可以对整个`Navigation`做新建等操作，在`Text`模式下可进行代码声明，如下所示：
```
<fragment
        android:id="@+id/home_dest"
        android:name="com.example.android.codelabs.navigation.HomeFragment"
        android:label="@string/home"
        tools:layout="@layout/home_fragment">
        <action
            android:id="@+id/next_action"
            app:destination="@+id/flow_step_one_dest"
            app:enterAnim="@anim/slide_in_right"
            app:exitAnim="@anim/slide_out_left"
            app:popEnterAnim="@anim/slide_in_left"
            app:popExitAnim="@anim/slide_out_right" />
</fragment>
```


### NavHostFragment
每个`Navigation`图都有一个起始的Fragment，这个Fragment将作为栈底(压栈，类似Activity的启动栈)，其在布局文件中如下声明：
```
<fragment
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    android:id="@+id/my_nav_host_fragment"
    android:name="androidx.navigation.fragment.NavHostFragment"
    app:navGraph="@navigation/nav_graph"
    app:defaultNavHost="true"
        />
```
* 这里面大家重点关注`android:name`和`app:defaultNavHost="true"`是声明启动的Fragment为`NavHostFragment`
* 下面的`app:navGraph`是将此fragment与`Navigation graph`做关联


### NavController
NavController是一个跟踪`Navigation graph`当前位置的对象，主要协调`NavHostFragment`显示对应的Fragment，可通过NavController控制跳转逻辑，安全传参(SafeArgs后面讲解)


### SafeArgs
使用`SafeArgs`需要导入Gradle插件(详情看注意事项第4点)，在传值类型会自动生成对应类型的class，所以官方推介使用SafeArgs进行传参


## 实践过程
1. 使用AndroidStudio 3.2以上版本
2. 在AndroidStudio 中导入教程下载的实验项目,此过程等待时间长短依据你当前的网络环境
3. 打开`app\src\main\res\navigation\nav_graph`文件(此文件就是上面提到的**Navigation graph**)
4. 切换页面内，下面的编辑模式到`Design`模式，在里面找到一个绿色的+号`New Destination`,在弹出的窗口内选择`SettingFragment`，恭喜你目前已经掌握**添加一个Fragment到Navigation Edit**
5. 接下来咱们切换到`MainFragment`，在`onCreateView`中加入`NavController navController = NavHostFragment.findNavController(MainFragment.this);
navController.navigate(R.id.twoFragment);`，这段代码意味着咱们从前面认识到的**NavHostFragment**中找到**NavController**，后面通过得到的**NavController**导航到ID叫`R.id.twoFragment`的目标
6. 接下来咱们切换到`TwoFragment`，在`onCreateView`中加入`NavController navController = NavHostFragment.findNavController(TwoFragment.this);
navController.navigate(R.id.mainFragment);`，这段代码意味着咱们从前面认识到的**NavHostFragment**中找到**NavController**，后面通过得到的**NavController**导航到ID叫`R.id.mainFragment`的目标
7. 运行项目
8. 至此你已经初步掌握了Navigation的入门用法！


## 注意事项
1. 运行环境必须是Android Studio3.2以上
2. 最低运行在API14设备以上


## 引用
[Navigation文档](https://developer.android.com/topic/libraries/architecture/navigation)
