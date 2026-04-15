import { Outlet, Link, useLocation } from 'react-router-dom'

export default function Layout() {
  const loc = useLocation()
  const nav = [
    { path: '/', label: '🏠 Home' },
    { path: '/emergency', label: '🚨 Emergency' },
    { path: '/blood-bank', label: '🩸 Blood' },
    { path: '/hospitals', label: '🏥 Hospitals' },
    { path: '/schemes', label: '📋 Schemes' },
  ]

  return (
    <div>
      <header style={{ background: '#01696f', padding: '1rem 2rem',
        display: 'flex', alignItems: 'center',
        justifyContent: 'space-between' }}>
        <Link to="/" style={{ color: 'white',
          fontWeight: 700, fontSize: '1.3rem', textDecoration: 'none' }}>
          🏥 AarogyaNet
        </Link>
        <nav style={{ display: 'flex', gap: '1rem', flexWrap: 'wrap' }}>
          {nav.map(n => (
            <Link key={n.path} to={n.path}
              style={{ color: loc.pathname === n.path
                ? '#ffffff' : '#cedcd8',
                textDecoration: 'none', fontSize: '0.9rem',
                fontWeight: loc.pathname === n.path ? 700 : 400 }}>
              {n.label}
            </Link>
          ))}
        </nav>
        <Link to="/login" style={{ color: 'white',
          textDecoration: 'none', fontSize: '0.9rem' }}>
          Login
        </Link>
      </header>
      <Outlet />
      <footer style={{ textAlign: 'center', padding: '2rem',
        background: '#f3f0ec', color: '#888', marginTop: '4rem' }}>
        © 2026 AarogyaNet | India's Rural Healthcare Platform
      </footer>
    </div>
  )
}