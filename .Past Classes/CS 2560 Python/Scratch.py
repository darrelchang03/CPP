class Vector:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def __str__(self):
        return f"<{self.x}, {self.y}>"

    def setX(self, x):
        self.x = x

    def setY(self, y):
        self.y = y

def main():
    v1 = Vector(2, 10)
    print(v1)  # will display <2, 10>
    v2 = Vector()
    print(v2)  # will display <0, 0>
    v2.setX(3)
    v2.setY(5)
    print(v2)  # now it will display <3, 5>

if __name__ == "__main__":
    main()
    
'''
<2, 10>
<0, 0>
<3, 5>
'''