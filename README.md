# Android-CleanArchitecture-basic

목적
- 가장 기초적인 Android Architecture Pattern 부터 모던 안드로이드 패턴까지 간단한 프로젝트를 진행하면서 정리하고자 합니다.
이를 바탕으로 스파게티 코드로 작성했었던 기존의 프로젝트를 수정하려 합니다. (기초탄탄)

안드로이드 애플리케이션 설계 패턴

1. MVC 디자인 패턴

구성요소
model, view, controller 세 가지 측면으로 관심사 분리
![image](https://github.com/guen-Kim/Android-CleanArchitecture-basic/assets/69742329/8b56ce48-8ff9-44ce-b50e-121aa46b0824)



Model
-  사용될 데이터 다룬다.
- 애플리케이션의 비지니스 로직(데이터를 생성·표시·저장·변경)을 갖는다.
ex) pojo 클래스 및  DB

View
- 데이터를 시각화하는 부분
- Model 이 처리한 데이터를  Controller 통해서 받아서 사용
- 어떠한 데이터나 로직이 들어가 있으면 안됨

Control
- 사용자로부터 특정 Event가 발생할 때 Model or View를 변경한다. 
ex) listener
- Model과 View를 느슨하게 이어준다.
- 유일하게 Model과 View에 의존한다. 이를 바탕으로 View와 Model 사이 데이터 흐름을 제어한다.


  MVC 작성 순서
  - 각 클래스의 의존관계에 따라 Model -> View -> Controller 순서로 작성하자. 


MVC를 지키면서 코딩하는 방법
1. Model은 Controller와 View에 의존하지 않아야 한다.
2. View는 Model에만 의존해야 하고, Controller에는 의존하면 안 된다.
3. View가 Model로부터 데이터를 받을 때는, 사용자마다 다르게 보여주어야 하는 데이터에 대해서만 받아야 한다.
4. Controller는 Model과 View에 의존해도 된다.
5. View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.


안드로이드에서 MVC 패턴
안드로이드에서 View와 Controller의 역할을 Activity, Fragment가 수행하게 되며, Model은 Data Class에 해당한다. 흔히 '스파게티 코드'라고 불린다.
![image](https://github.com/guen-Kim/Android-CleanArchitecture-basic/assets/69742329/ccd90622-de61-49db-a846-bab49b7f8c72)


MVC패턴의 의존성 및 단점
- Controller는 View와 Model에 의존적이고 View는 Model에 의존적이라 결합도가 높다.
- Activity 나 Fragment에 거의 모든 로직이 작성되는 경향이 있다. 그러므로 큰 프로젝트에 사용되는 코드로 적합하지 않다.



2. MVP 디자인 패턴
Model과 View의 역할은 MVC 디자인 패턴과 동일하다. Controller 대신 Presenter이라는 개념을 통해 UI(View)와 비즈니스 로직(Model)을 분리하여 영향(의존성)을 최소화하는 것에 있다.

![image](https://github.com/guen-Kim/Android-CleanArchitecture-basic/assets/69742329/42f85fe7-4197-47b0-8791-c42d2b834eec)


Model
- 프로그램 내부적으로 쓰이는 데이터를 저장하고, 처리한다. (비지니스 로직)
- View or Presenter등 다른 어떤 요소에도 의존적이지 않은 독립적이다.


View
- 공통적으로 화면에 데이터를 출력하는 역할, 안드로이드 에서는 Activity, Fragment, holer 등
- Model에서 처리된 데이터를 Presenter를 통해 받아서 유저에게 보여준다.
- 유저 액션(Action) 및 액티비티 라이프사이클 상태 변경을 주시하며 Presenter에 보내는 역할을 한다.
- Contract interface에 정의된 view의 기능을 구현한다.
- Presenter를 통해 데이터를 주고받기 때문에 Model에 매우 의존적이다.

Presenter
- Model과 View사이의 매개체이며 이 두 Component를 이용해 Contract interface에 정의된 Presenter의 기능을 구현한다. 
- Controller와 유사하지만, View를 직접 참조하지 않고 View interface를 구현한 Concrete Class와 상호작용한다.
- 뷰에게 표시할 내용(Data)만 전달하고 어떻게 보여줄지는 View가 한다.


+ Contract interface
- MVP 패턴에서 사용될 API를 정의한다.
- MVP 패턴에서 역할을 구분하고 책임을 명확히 나타낸다.
- 대게 View interface와 Presenter interface가 정의되며 MVP 패턴 설계될 class는 이  역할에 따라interface를 구현해 사용하면된다.

MVP 디자인 패턴의 장단점
Presenter는 View와 Model의 인스턴스를 가지며 이 둘을 연결해 주는 역할을 하므로 Presenter와 View는 1:1 관계를 갖는다. 이를 바탕으로
장점
View와 Model 간의 의존성이 없다. 그러므로 UI코드 와 비지니스로직을 분리해 유닛 테스트가 수월하다.
단점
View와 Presenter 간의 의존성이 높고, 1:1 관계를 융지해야 해서 Presenter를 재사용할 수 없어 View가 늘어날 때마다 Presenter도 같이 늘어나 클래스가 많아지게된다. 또한 앱 기능이 많아질수록 Presenter가 거대해지는 단점이있다.





3. MVVM 디자인 패턴





  
