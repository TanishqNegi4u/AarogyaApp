import { useState } from 'react'

const mockData = [
  { hospital: 'Muzaffarnagar District Hospital', group: 'O+', units: 20, dist: '2 km' },
  { hospital: 'PHC Budhana', group: 'A+', units: 4, dist: '15 km' },
  { hospital: 'AIIMS Delhi', group: 'O+', units: 60, dist: '120 km' },
]

export default function BloodBankPage() {
  const [group, setGroup] = useState('O+')
  const [results, setResults] = useState(mockData)

  const search = () => {
    setResults(mockData.filter(d => d.group === group))
  }

  return (
    <main style={{ padding: '2rem', maxWidth: '700px', margin: '0 auto' }}>
      <h1 style={{ color: '#01696f', fontSize: '2rem' }}>🩸 Blood Bank</h1>
      <p style={{ color: '#666', marginBottom: '2rem' }}>
        Find available blood units near you
      </p>

      <div style={{ display: 'flex', gap: '1rem', marginBottom: '2rem' }}>
        <select value={group} onChange={e => setGroup(e.target.value)}
          style={{ padding: '0.75rem', borderRadius: '8px',
            border: '1px solid #ccc', fontSize: '1rem', flex: 1 }}>
          {['A+','A-','B+','B-','O+','O-','AB+','AB-'].map(g =>
            <option key={g} value={g}>{g}</option>)}
        </select>
        <button onClick={search}
          style={{ padding: '0.75rem 1.5rem', background: '#01696f',
            color: 'white', border: 'none', borderRadius: '8px',
            fontSize: '1rem', cursor: 'pointer' }}>
          Search
        </button>
      </div>

      {results.map((r, i) => (
        <div key={i} style={{ padding: '1rem', background: '#f9f8f5',
          borderRadius: '8px', marginBottom: '1rem',
          border: '1px solid #dcd9d5' }}>
          <strong>{r.hospital}</strong>
          <div style={{ display: 'flex', gap: '2rem', marginTop: '0.5rem' }}>
            <span>🩸 {r.group}</