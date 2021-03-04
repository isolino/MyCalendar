# MyCalendar
A lib to manipulate android calendar

This project contains the calendar manager lib and the MyCalendar App (that uses this lib).

The calendar Manager API provides methods to create, delete and list calendars. And methods to include, remove and update events in a calendar.

The MyCalendar App uses Jetpack compose and ViewModel as view Controler

The first step is define a  archtecture of project. In this case will bem MVVM. So the we will have a ViewModel listen to the user interaction with some livedata been observerd by the view. The  responsibility of instatiate this ViewModel and its dependencies will lay on Hilt. Once this structure are created, we will create a CalendarManager or Reposiitory API, that will be a library in de future.

So to accomplish the first step, we will create a Activity, A fragment and a ViewModel. These elements will be in a package called view.

Create a project with no Activity.
Create a Blank activity
include a fragment host in the activity
create a fragment
create a navigation graph and associate with fragment host on created activity

Once the ViewModel are created, its time to use it in the fragment (view). For do this, we will use use HHilt anotations over some android classes like Application, Activity and Fragment
