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
안드로이드에서 View와 Controller의 역할을 Activity, Fragment가 수행하게 되며, Model은 Data Class에 해당한다.
![image](https://github.com/guen-Kim/Android-CleanArchitecture-basic/assets/69742329/ccd90622-de61-49db-a846-bab49b7f8c72)


MVC패턴의 의존성 및 단점
- Controller는 View와 Model에 의존적이고 View는 Model에 의존적이라 결합도가 높다.
- Activity 나 Fragment에 거의 모든 로직이 작성되는 경향이 있다. 그러므로 큰 프로젝트에 사용되는 코드로 적합하지 않다.
  
