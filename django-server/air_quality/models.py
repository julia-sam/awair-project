from django.db import models

# Create your models here.

class AwairModel(models.Model):
    timestamp = models.CharField(max_length=125)
    score = models.FloatField()
    temp = models.FloatField()
    humid = models.FloatField()
    co2 = models.FloatField()
    voc = models.FloatField()
    pm25 = models.FloatField()