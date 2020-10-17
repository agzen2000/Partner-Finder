import React from 'react';
import './App.css';
import AppFooter from './AppFooter';
import AppHeader from './AppHeader';
import UserQuery from './UserQuery';

function App() {
  return (
    <div className="app">
      <div className="app__header">
        {/* top gray box with shapes */}
        <AppHeader />
      </div>
      <div className="app__body">
        <UserQuery />
      </div>
      <div className="app__footer">
        <AppFooter />
      </div>
    </div>
  );
}

export default App;
