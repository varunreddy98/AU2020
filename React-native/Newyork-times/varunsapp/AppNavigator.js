import { createStackNavigator } from 'react-navigation';
import Login from './views/Login';
import Home from  './views/Home';

const AppNavigator = createStackNavigator({
  Login: { screen: Login },
  Home: {screen:Home},
});

export default AppNavigator;