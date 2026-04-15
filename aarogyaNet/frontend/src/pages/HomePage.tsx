import { Link } from 'react-router-dom'

export default function HomePage() {
  const features = [
    { title: '🚨 Emergency SOS', desc: 'Instant ambulance & help', link: '/emergency' },
    { title: '🩸 Blood Bank', desc: 'Find blood near you', link: '/blood-bank' },
    { title: '🏥 Hospitals', desc: 'Locate health centers', link: '/hospitals' },
    { title: '📋 Schemes', desc: 'Govt health schemes', link: '/schemes' },
  ]

  return (
    <main style={{ padding: '2rem', maxWidth: '900px', margin: '0 auto' }}>
      <div style={{ textAlign: 'center', marginBottom: '3rem' }}>
        <h1 style={{ fontSize: '2.5rem', color: '#01696f', fontWeight: 700 }}>
          🏥 AarogyaNet
        </h1>
        <p style={{ fontSize: '1.2rem', color: '#555', marginTop: '1rem' }}>
          India's Rural Healthcare & Emergency Response Platform
        </p>
        <p style={{ color: '#888' }}>
          भारत का ग्रामीण स्वास्थ्य सेवा मंच
        </p>
      </div>

      <div style={{
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))',
        gap: '1.5rem'
      }}>
        {features.map(f => (
          <Link key={f.link} to={f.link}
            style={{
              padding: '2rem',
              background: '#f0fafa',
              borderRadius: '12px',
              textDecoration: 'none',
              color: '#222',
              border: '1px solid #cedcd8',
              transition: 'all 0.2s'
            }}>
            <div style={{ fontSize: '2rem' }}>{f.title.split(' ')[0]}</div>
            <div style={{ fontWeight: 600, marginTop: '0.5rem' }}>
              {f.title.split(' ').slice(1).join(' ')}
            </div>
            <div style={{ color: '#666', fontSize: '0.9rem' }}>{f.desc}</div>
          </Link>
        ))}
      </div>
    </main>
  )
}