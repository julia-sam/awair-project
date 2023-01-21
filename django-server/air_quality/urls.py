from django.urls import path
from . import views

urlpatterns = [
    path('consume_data/', views.consume_data, name="consume_data"),
    path('display_data/', views.display_data, name="display_data"),
    path('request_json/', views.request_json, name=("request_json")),
    path('display_average/', views.display_average, name="display_average"),
]