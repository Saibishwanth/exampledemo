#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using std::cout;
using std::cin;

enum class Month {
  January,
  February,
  March,
  April,
  May,
  June,
  July,
  August,
  September,
  October,
  November,
  December
};

Month inputMonth()
{
  static std::unordered_map<std::string, Month> monthMap = {
      {"January", Month::January},
      {"February", Month::February},
      {"March", Month::March},
      {"April", Month::April},
      {"May", Month::May},
      {"June", Month::June},
      {"July", Month::July},
      {"August", Month::August},
      {"September", Month::September},
      {"October", Month::October},
      {"November", Month::November},
      {"December", Month::December}};

  while (true) {
    std::cout << "Enter month: " << std::endl;
    std::string str;
    std::cin >> str;
    auto it = monthMap.find(str);
    if (it != monthMap.end()) {
      return it->second;
    } else {
        std::cout << "Invalid month given. Should be one of: ";
        std::cout << "[January February March April May June July August September October November December]\n";
        std::cout << "Try again" << std::endl;
    }
  }
}

// Function to get number of days in month
int getNumberOfDays(Month month)
{
  switch (month) {
    case Month::January:
    case Month::March:
    case Month::May:
    case Month::July:
    case Month::August:
    case Month::October:
    case Month::December:
      return 2;
    case Month::April:
    case Month::June:
    case Month::September:
    case Month::November:
      return 30;
    case Month::February:
      return 28;  // For simplicity, not considering leap years
  }
  throw std::runtime_error("Invalid month");  // Invalid month
}

struct Attendance{
   int ts; //Total Strength
   int tp; //Total Present
};

std::vector<Attendance> getAttendance(Month month){

 int noDays=getNumberOfDays(month);
 std::vector<Attendance> v(noDays);
 for(int i=0;i<noDays;i++)
 {
    cout<<"Enter Total Strength on Day "<<i+1<<": ";cout.flush();
    cin>>v[i].ts;
    cout<<"Enter Total present on Day "<<i+1<<": ";cout.flush();
    cin>>v[i].tp;
    cout<<"\n";
 }
 return v;
}

struct balance{
    int opb=100;
    int cb=0;
};
int main()
{
  Month input = inputMonth();
  std::vector<Attendance> v = getAttendance(input);

  int opb=100;
  int cb=0;int item =2;
  int n=v.size();
  for(int i=0;i<n;i++)
  {
    cout<<" Day "<<i+1<<": ";
    cout<<"\nopening balance: "<<opb;
    cb=opb-(v[i].tp*item);
    opb=cb;
    cout<<"\nclosing balance: "<<cb;
    cout<<"\n";
  }

}
